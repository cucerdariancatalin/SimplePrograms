past = 0
present = 0
result = 0
lgth = 0

lgth = int(input("- How many numbers? \n"))
print("- " + str(lgth))

print(str(result) + " ", end="")
present = 1

while lgth > 0:
    result = present
    present += past
    past = result
    print(str(result) + " ", end="")
    lgth -= 1
