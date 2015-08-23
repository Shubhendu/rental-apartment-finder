rental-apartment-finder app
==============

## Description of the app
This app is built to show Rental apartment postings on Craiglist.
It supports search for all the cities supported by Craiglist in US.
User can filter the records by following search criterias - City, No. of bedrooms, No. of bathrooms, Minimum Price, Maximum price and Rental control require.
The app displays resulting lisitings in a paginated format.
Only 100 records are fetched in the UI at a time.
There is a button on the last page which fetches next set of 100 records from server.  
There is a note at the bottom of grid which displays the total record count information.

## Pre-requisites to run the app- 
-Ensure Java 1.7 or more is installed on your machine.
	You can check it by running this command on your terminal-
	
	java -version

	If java is installed on your machine, you will get something like this -

	java version "1.7.0_79"
	Java(TM) SE Runtime Environment (build 1.7.0_79-b15)
	Java HotSpot(TM) 64-Bit Server VM (build 24.79-b02, mixed mode)
	
	If you don't have any java installed on your machine then download it from here-
	http://www.oracle.com/technetwork/java/javase/downloads/jre7-downloads-1880261.html

-Ensure that port 9090 is available.If not then "server.port" property in the application.properties needs to be changed. A build will be required if that change is made.


## Steps to run this app -

	1- Download this zip file.
	2- Unzip the file.
	3- Run the jar file located under target directory. Type this command on your terminal to run it-
		java -jar <jar_file_name>
	4- Open your browser and type -
		http://localhost:9090/

	5- This app should work for all the cities supported by craigslist. The city dropdown has all the cities. You can select or type to get the city name.

