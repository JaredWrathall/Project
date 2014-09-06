""" This program detirmes how it would cost to purchase all items in the shopping_list variable """

# what we want to buy from the store
shopping_list = ["banana", "orange", "apple"]

# what the store has in stock
stock = {
    "banana": 6,
    "apple": 0,
    "orange": 32,
    "pear": 15
}

# prices of each item    
prices = {
    "banana": 4,
    "apple": 2,
    "orange": 1.5,
    "pear": 3
}

# the function used to compute the cost of the trip
def compute_bill(food):
    total = 0
     
    for item in food:

        # we can only purchase the items if they have the item in stock
        if stock[item] > 0:

            # add the price of the item to the total bill
            total = total + prices[item]

            # update the stock count for this item
            stock[item] = stock[item] - 1
                
    return total

# print the total
print(compute_bill(shopping_list))