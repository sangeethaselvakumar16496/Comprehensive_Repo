import pytest


# Data fixture 1
@pytest.fixture
def user_credential():
    return {
        'username': 'test_user',
        'password': 'pwd123456'
    }


# Data fixture 2
@pytest.fixture
def product_details():
    return {
        'product_name': 'Laptop',
        'price': 60000.00,
        'quantity': 1
    }


# Test function using user_data fixture
def test_user_creation(user_credential):
    # Your test logic using user_data
    assert len(user_credential['username']) > 0
    assert len(user_credential['password']) >= 8


# Test function using product_data fixture
def test_product_pricing(product_details):
    assert len(product_details['product_name']) > 0
    print("Product name:", product_details['product_name'])
    assert product_details['price'] > 0
    print("Product price:", product_details['price'])
    assert product_details['quantity'] >= 0
    print("Product quantity:", product_details['quantity'])
