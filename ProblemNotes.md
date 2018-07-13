# Design Notes

## Background
Home insulation is important and helps reduce electricity consumption. The quality of home insulation is represented by a value called "rValue", {0.0 < rValue < 50.0}, with three digits of precision. 

## Objective
Make a program to rate homes according to rValue and assign a rank from 1 to 10 (10 being best) for specific regions. 

### Conditions: 
- Each rValue is to be compared against values of the same region, with region being either country, state or city.
  
  Ex: &quot;John Doe&quot; &quot;Canada/Ontario/Toronto&quot; 1.5 --> calculate score based on Toronto region.   
  Ex: &quot;Adam Xin&quot; &quot;Canada/British Columbia&quot; 2.110 --> calculate score based on BC region.  
  
- The rank 1-10 of an rValue is based on the "percentileScore" of all rValues for that region, and is calculated as follows:  
Rank 1 = {0 <= percentileScore < 10}, Rank 2 = {10 <= percentileScore < 20}, ... , Rank 10 = {90 <= percentileScore < 100}

## Input Format
- Data: "name" "location" rValue  
  - location: "country/state/city"  
- Empty line  
- Query: "name" "region"  
  - region:  
    - "country"  
    - "country/state"  
    - "country/state/city"  
## Output Format
- Data: "name" "region" score
  - region:  
    - "country"  
    - "country/state"  
    - "country/state/city" 

