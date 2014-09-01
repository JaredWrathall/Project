pyg = 'ay'

original = input('Enter a word: ')

# turn the original word into lowercase
word = original.lower()

if len(original) > 1 and original.isalpha():
    
    # get the first letter of the word
    first = word[0]
    
    # put it all together
    new_word = word[1:len(word)] + first + pyg
    
    print(new_word)   
    
elif len(original) == 0:
    
    print(original + pyg )
    
else:
    print('Invalid Input')  