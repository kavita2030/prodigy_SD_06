import requests
from bs4 import BeautifulSoup
import pandas as pd

# Define the URL of the website
url = "http://books.toscrape.com/"

# Send a GET request to the website
response = requests.get(url)

# Check if the request was successful (status code 200)
if response.status_code == 200:
    # Parse the HTML content of the page using BeautifulSoup
    soup = BeautifulSoup(response.content, 'html.parser')

    # Lists to store the extracted data
    product_names = []
    product_prices = []
    product_ratings = []

    # Find all the product listings on the page
    products = soup.find_all('article', class_='product_pod')

    # Loop through each product and extract details
    for product in products:
        # Extract the product name
        name = product.h3.a['title']
        product_names.append(name)

        # Extract the price (strip £ symbol)
        price = product.find('p', class_='price_color').text.strip('£')
        product_prices.append(price)

        # Extract the rating (class-based representation of rating)
        rating_class = product.p['class'][1]
        product_ratings.append(rating_class)

    # Create a pandas DataFrame to structure the data
    product_data = pd.DataFrame({
        'Product Name': product_names,
        'Price (£)': product_prices,
        'Rating': product_ratings
    })

    # Save the data to a CSV file
    product_data.to_csv('scraped_products.csv', index=False)
    print("Data successfully saved to 'scraped_products.csv'")
else:
    print("Failed to retrieve the website. Status code:", response.status_code)
