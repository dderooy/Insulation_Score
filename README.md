# Home Insulation Rank

## Background
Home insulation is important and helps reduce electricity consumption. The quality of home insulation is represented by a 
variable called "rValue", {0.0 < rValue < 50.0}, with three digits of precision. A home with good insulation has a high
rValue while a home with poor insulation has a low rValue.

## Objective
Make a program to rate homes according to rValue and assign a rank from 1 to 10 (10 being best) for specific regions. 

### Conditions: 
- Each rValue is to be compared against values of the same region, with region being either country, state or city.
  
  Ex: &quot;John Doe&quot; &quot;Canada/Ontario/Toronto&quot; 1.5 --> calculate score based on Toronto region.   
  Ex: &quot;Adam Xin&quot; &quot;Canada/British Columbia&quot; 2.110 --> calculate score based on BC region.  

- Given a specific home and region, the rank is determined as follows: If the percentage of homes with a higher rValue is:
   - [90,100) --> rank = 1
   - [80,90) --> rank = 2
   - ...
   - [0,10) --> rank = 10
        

## Sample input
```
"John Doe" "Canada/Ontario/Toronto" 1.5
"Samanta Smith" "Canada/Ontario/London" 3.7
"Adam Xin" "Canada/British Columbia/Vancouver" 2.110
"Monica Taylor" "Canada/Ontario/Toronto" 2.110
"Alicia Yazzie" "US/Arizona/Phoenix" 5.532
"Mohammed Zadeh" "Canada/Ontario/Toronto" 1.43

"John Doe" "Canada"
"John Doe" "Canada/Ontario"
"Alicia Yazzie" "US/Arizona" 
```
The first set of lines represent raw data with rValue scores. A query set of lines come after the space. 

## Sample output
```
"John Doe" "Canada" 4
"John Doe" "Canada/Ontario" 5
"Alicia Yazzie" "US/Arizona" 10
```
The program outputs one line with the resulting score for each query

## Building the program

- Requirements:
    - Java 10
    - Maven 3.5.3
 
Clone this repo and run "mvn clean install" in directory. Go to mvn repo and get jar.

## Running the program
```
$ cat testData.txt | java -jar rValueRank.jar
```

