""" This program detirmes how much a potential vacation could cost """

# hotel cost
def hotel_cost(nights):
    return nights * 140;

# plane cost    
def plane_ride_cost(city):
    if city == "Charlotte":
        return 183
    elif city == "Tampa":
        return 220
    elif city == "Pittsburgh":
        return 222
    elif city == "Los Angeles":
        return 475
    else:
        return 0
 
# car rental cost       
def rental_car_cost(days):
    if days >= 7:
        return (days * 40) - 50
    elif days >= 3:
        return (days * 40) - 20
    else:
        return days * 40
        
# sum it all together       
def trip_cost(city, days, spending_money):
    return hotel_cost(days) + plane_ride_cost(city) + rental_car_cost(days) + spending_money

print("Your trip cost is below:")

# display the trip cost to LA    
print (trip_cost("Los Angeles", 5, 600))
