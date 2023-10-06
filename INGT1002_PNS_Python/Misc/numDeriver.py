"""
Beregn f'(1) for følgende funksjoner
1) f(X) = x^2
2) f(x) = lnx
3) f(x) = x*sinx
4) f(x) = arctan(x) #invers tan(x)


"""
delta_x = 1E-1
x = 1

def f(x):
    return (x-3)**2 + 3

def derivate(f, x, delta_x = 1E-6):
    return (f(x + delta_x) - f(x)) / (delta_x)

def senterDerivate(f, x, delta_x = 1E-6):
    return (f(x + delta_x) - f(x - delta_x)) / (2*delta_x)


#print(derivate(f, x, delta_x))
print(senterDerivate(f, x, delta_x))
# print(abs(derivate(f, x, delta_x) - senterDerivate(f, x, delta_x)))