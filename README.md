** Developer Comments **

Technologies used:
-------------------
1. Spring RestController
2. SOA 
3. Factory Design Pattern
4. Log4J
5. Java 1.8
6. Spring SOAP WebServiceTemplate
7. JSON
8. properties file


Work done
--------------
1.Client Request Class is implemented with new interface and have similar method of setRequest.
  Which map BusyRequest to respective Supplier Request.
  
2.Client Response Class is implemented with new interface and have similar method of getResponse.
  Which map respective Supplier Response to BusyFlightResponse.
  
3.Different web service Component are implemented for different Suppliers.

4.Suppliers respective ContextPath and URI is set in Properties File.
  These are used to call remote web service methods.

5. One validation service implemented to validate request.

6. RestController receive the request of BusyFlightRequest and set all respective fields using org.springframework.ui.Model.

7. Validation check for request elements.

8. After passing of validation service searchFlights service invoked.

9. In search of flight all suppliers key value is picked from properties file in a list.

10. By iterating this list of supplier key, factory design for supplier request gives us object of request of     
    different suppliers in iteration 
    and response of all supplier is combined using respective Client Class getFlights Method.
   
11. The Final Combine List is Sorted using Lambda expression.
   
 Extensible
-------------------

 If new Supplier introduce :
 
 1. no change in Service Layer and other layers.
 2. Following addition required for new supplier:
 	2.1 ADD of Request and Response class of new supplier.
 	2.3 Add the new supplier in properties file(URI,PATH,NameKey).
 	2.4 Add the client for the supplier.
 	 
 
Limitation
-----------

1. Error handling may be more effective.
2. As dummy URI is consider so authentication and session management is not taking care.
3. Remote API Fail cases are not considered.
4. Concurrency control is not considered properly.


**Travix - Problem to be solved**

**Background:**

BusyFlights is a flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet). A future iteration (not part of the test) may add more suppliers.

**Recommended duration of test:**

Allocate no more than 90 minutes to complete this exercise. An incomplete solution is acceptable but documenting any remaining tasks and next steps is expected. 

**What is required:**

Use this GitHub repository as a base to implement the Busy Flights service that should produce an aggregated result from both CrazyAir and ToughJet.
The result should be a JSON response which contains a list of flights ordered by fare which has the following attributes:

**Busy Flights API**

**Request**

| Name | Description |
| ------ | ------ |
| origin | 3 letter IATA code(eg. LHR, AMS) |
| destination | 3 letter IATA code(eg. LHR, AMS) |
| departureDate | ISO_LOCAL_DATE format |
| returnDate | ISO_LOCAL_DATE format |
| numberOfPassengers | Maximum 4 passengers |

**Response**

| Name | Description |
| ------ | ------ |
| airline | Name of Airline |
| supplier | Eg: CrazyAir or ToughJet |
| fare | Total price rounded to 2 decimals |
| departureAirportCode | 3 letter IATA code(eg. LHR, AMS) |
| destinationAirportCode | 3 letter IATA code(eg. LHR, AMS) |
| departureDate | ISO_DATE_TIME format |
| arrivalDate | ISO_DATE_TIME format |

The service should connect to the both the suppliers using HTTP.

**CrazyAir API**

**Request**

| Name | Description |
| ------ | ------ |
| origin | 3 letter IATA code(eg. LHR, AMS) |
| destination | 3 letter IATA code(eg. LHR, AMS) |
| departureDate | ISO_LOCAL_DATE format |
| returnDate | ISO_LOCAL_DATE format |
| passengerCount | Number of passengers |

**Response**


| Name | Description |
| ------ | ------ |
| airline | Name of the airline |
| price | Total price |
| cabinclass | E for Economy and B for Business |
| departureAirportCode | Eg: LHR |
| destinationAirportCode | Eg: LHR |
| departureDate | ISO_LOCAL_DATE_TIME format |
| arrivalDate | ISO_LOCAL_DATE_TIME format |

**ToughJet API**

**Request**

| Name | Description |
| ------ | ------ |
| from | 3 letter IATA code(eg. LHR, AMS) |
| to | 3 letter IATA code(eg. LHR, AMS) |
| outboundDate |ISO_LOCAL_DATE format |
| inboundDate | ISO_LOCAL_DATE format |
| numberOfAdults | Number of passengers |

**Response**

| Name | Description |
| ------ | ------ |
| carrier | Name of the Airline |
| basePrice | Price without tax(doesn't include discount) |
| tax | Tax which needs to be charged along with the price |
| discount | Discount which needs to be applied on the price(in percentage) |
| departureAirportName | 3 letter IATA code(eg. LHR, AMS) |
| arrivalAirportName | 3 letter IATA code(eg. LHR, AMS) |
| outboundDateTime | ISO_INSTANT format |
| inboundDateTime | ISO_INSTANT format |

**What you need to provide:**

- A solution that meets the above requirements.
- The implementation should be made as close to 'production ready' as possible within the time constraints.

It is fine to change any of the supplied application code, if you choose to do so please add comments to indicate what has changed and why.

**Note**

Please clone this project then create your own repository from it. Do not fork/branch this project when creating your solution as it will be visible to other applicants.