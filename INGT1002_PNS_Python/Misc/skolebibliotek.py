# Authored by: Sander Sandvik Nessa, Kim Alexander Antonsen, and Fabian Lea
# Version 1.2.0

import pylab as py


def euler(yder, start, stop, res, Y0):
    """
    Parameters
    ----------
    yder : function
        Derivated function.
    start : int
        Starts at this x value.
    stop : int
        Stops at this x value.
    res : int
        Resolution.
    Y0 : float or int
        Starting value for function when x = the staring value.

    Returns
    -------
    x : list of float
        Returns the x value.
    y : list of float
        Returns the y value.

    """
    #Variables    
    x = py.linspace(start, stop, res)
    y = []
    dt = (stop - start) / (res - 1) #delta t
    
    y.append(Y0) #Starting y value
    
    for i in range(res - 1):
        y.append(y[i] + yder(y[i], x[i])*dt)
    

    return x, y


def function_crossing(f, g, low, high, res):
    """
    Parameters
    ----------
    h : function
        Function one.
    g : function
        Function two.
    low : int or float
        Starts at this x value to find crossing.
    high : int or float
        Stops at this x value.
    res : int
        Resolution of the first sweep.

    Returns
    -------
    crossings : list
        Returns list of x values for crossing points

    """
    #Constants
    TOL = 1 * 10**-10 #tol limit
    i = 0
    iterations = res - 2
    
    crossings = []
    x = py.linspace(low, high, res)
    # Finds where the graphs cross
    while i <= iterations:
        if f(x[i]) > g(x[i]) and f(x[i+1]) < g(x[i+1]):           
            low_x = x[i]
            high_x = x[i+1]
            while (f(low_x) - g(low_x)) > TOL:
                mid_x = low_x + ((high_x - low_x) / 2)
                if f(mid_x) > g(mid_x):
                    low_x = mid_x
                elif f(mid_x) < g(mid_x):
                    high_x = mid_x
            crossings.append(mid_x)
            
        elif f(x[i]) < g(x[i]) and f(x[i+1]) > g(x[i+1]):
            low_x = x[i]
            high_x = x[i+1]
            while (g(low_x) - f(low_x)) > TOL:
                mid_x = low_x + ((high_x - low_x) / 2)
                if g(mid_x) > f(mid_x):
                    low_x = mid_x
                elif g(mid_x) < f(mid_x):
                    high_x = mid_x            
            crossings.append(mid_x)
            
        elif f(x[i]) == g(x[i]):
            crossings.append(x[i])
        i += 1
    
    return crossings


def bisection_method(f, low_val, high_val):
    """
    Parameters
    ----------
    f : function
        A function returning a y value for x.
    low_val : float or int
        Starts looking for f = 0 from this point.
    high_val : float or int
        Stops at this value.

    Returns
    -------
    x : float or int
        Returns the x value when f = 0

    """
    
    # Constants
    TOL = 1E-10 # tol limit
    iterations = 10000 # max iterations

    # Variables
    i = 0 # iterations
    mid_val = (low_val + high_val)/2
    
     
    while i < iterations and abs(f(mid_val)) > TOL:
        if f(low_val)*f(mid_val) < 0:
            high_val = mid_val
        else:
            low_val = mid_val

        i += 1
        mid_val = (low_val + high_val)/2

    if abs(f(mid_val)) < TOL:
        return mid_val
    else:
        return None


def derivated(f, x, delta_x):
    """
    Parameters
    ----------
    f : function
        A function returning a y value for x.
    x : int
        x value to be derivated.
    delta_x : float or int
        Step for x.

    Returns
    -------
    fder : float or int
        The derivated value.

    """
    fder = (f(x+delta_x)-f(x-delta_x))/(2*delta_x)
    return fder


def newtons_method(f, x):
    """
    Parameters
    ----------
    x : float or int
        Starting x value to find f = 0.

    Returns
    -------
    x : float or int
        Returns the x value for f = 0

    """
    # Constants
    iterations = 10000 # max iterations
    TOL = 1E-10 # tol limit

    # Variables
    i = 0 #iterations 

    while i < iterations and abs(f(x)) > TOL:
        x = x - f(x)/derivated(f,x, 0.00001)
        i += 1

    return x


def definite_integral(f, start, stop, res):
    """
    Parameters
    ----------
    f : function
        A function returning a y value for x.
    start : float or int
        Starting x value.
    stop : float or int
        Stoping x value.
    res : int
        Resolution for definite_integral.

    Returns
    -------
    float 
        Returns the definite integral.

    """
    dx = (stop - start) / res
    Area = (f(start) + f(stop))/2
    for i in range(1,res-1):
        Area += f(start + i*dx)
    return Area*dx


def undefinite_integral(yder, start, stop, res, Y0):
    """
    Parameters
    ----------
    yder : function
        Derivated function.
    start : int
        Starts at this x value.
    stop : int
        Stops at this x value.
    res : int
        Resolution.
    Y0 : float or int
        Starting value for function when x = the staring value.

    Returns
    -------
    x : list of float
        Returns the x value.
    y : list of float
        Returns the y value.

    """
    return euler(yder, start, stop, res, Y0)


def find_energy(equation):
    """
    Parameters
    _________
    equation : string
        The equation

    Returns
    -------
    massesvinn : float
        The difference in mass between the two sides of the equation
    
    energi : float
        The energy made from the difference in mass
    """
    
    #Opens the file Nuklider.txt and puts the data into a dictionary with all the nuclides
    in_file = open("Nuklider.txt", "r")

    nuklider = {"n": 1.008664916}

    for i in range(int(25440/8)):
        in_file.readline()
        symbol = in_file.readline()[16:-1]
        nuklidetall = in_file.readline()[14:-1]
        RAM = in_file.readline()[23:-1]
        if "(" in RAM:
            RAM = RAM[:RAM.find("(")]
        for i in range(4):
            in_file.readline()
        navn = symbol + nuklidetall
        if RAM == "":
            RAM = 0
        nuklider[navn] = float(RAM)

    in_file.close()
    
    #Turns the equation into a list for each sides with all the nuclides
    ligning = equation.split(" = ")
    venstre = ligning[0].split(" + ")
    høyre = ligning[1].split(" + ")
    
    def koeffisienter(side):
        #Makes new lists for each side and puts multiples of each nuclide in the lists if it has a coefficient
        """
        Parameters
        ----------
        side : list
            Which side of the equation that you want to check for coefficients

        Returns
        -------
        nyside : list
            The new list for the side

        """
        nyside = []
        for i in side:
            if i[0].isnumeric():
                for char in i:
                    if char.isalpha():
                        førstebokstav = i.index(char)
                        break
                koeffisient = int(i[:førstebokstav])
                for j in range(koeffisient):
                    nyside.append(i[førstebokstav:])
            else:
                nyside.append(i)
        return nyside
    
    venstre = koeffisienter(venstre)
    høyre = koeffisienter(høyre)
    
    def finnmasse(side):
        """
        Parameters
        ----------
        side : list
            The side you want to calculate the mass for

        Returns
        -------
        masse : float
            The sum of the mass of the nuclides from this side of the equation
        """
        masse = 0
        for i in side:
            masse += nuklider[i]
        return masse
    
    venstremasse = finnmasse(venstre)
    høyremasse = finnmasse(høyre)
    
    #Calculates the mass difference and energy
    massesvinn = venstremasse-høyremasse
    energi = massesvinn*1.66*10**(-27)*(300000000)**2
    
    return massesvinn, energi


def poping(before_pop):
    """
    Parameters
    ----------
    before_pop : List
        List of pirates.

    Returns
    -------
    after : list
        The person who survived.
    (Collective Suicide)

    """
    after = []   
    for i in range(0, len(before_pop), 2):
        after.append(before_pop[i])
    if (len(before_pop) % 2 != 0):
        after.pop(0)
    if (len(after) > 1):
        after = poping(after)
    return after
