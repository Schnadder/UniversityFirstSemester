
num = 0.25
def numToBinary(num, decimal = 4):
    integer = int(num)
    fractional = num - integer
    
    #Integer part
    int_output = ""
    while integer > 0:
        bit = integer % 2  # Get the least significant bit
        integer //= 2  # Shift right by one bit
        int_output = str(bit) + int_output
    if not int_output:
        int_output = "0"
        
    #Fractional part
    fraction_output = ""
    for i in range(decimal):
        fractional *= 2
        if fractional >= 1:
            bit = '1'
        else:
            bit = '0'
        fractional -= int(bit)
        fraction_output += bit

    output = int_output + "." + fraction_output        
        
        
    return output

print(numToBinary(num))