var app = angular.module("apartmentFinderApp", []);
var dummyData = [{"postingDate":"2015-08-21 16:15","url":"http://sfbay.craigslist.org/sby/apa/5184327005.html","price":"$1875","description":"Welcome Home! Best Price! Rent Control!","location":"San jose west","size":"1 bedrooms"},{"postingDate":"2015-08-21 09:09","url":"http://sfbay.craigslist.org/sby/apa/5183606123.html","price":"$1700","description":"Nice 1BR 1BA near WestGate Mall for rent","location":"San jose west","size":"1 bedrooms"},{"postingDate":"2015-08-16 11:20","url":"http://sfbay.craigslist.org/eby/apa/5175574022.html","price":"$1595","description":"Lovely 2 Br - Concord Townhouse Rent $1.","location":"Concord / pleasant hill / martinez","size":"2 bedrooms"},{"postingDate":"2015-08-22 15:58","url":"http://sfbay.craigslist.org/eby/apa/5185841538.html","price":"$1970","description":"Everything You Need! Amazing One Bedroo.","location":"Hayward / castro valley","size":"1 bedrooms"},{"postingDate":"2015-08-22 15:43","url":"http://sfbay.craigslist.org/eby/apa/5185819448.html","price":"$1875","description":"Large One Bedroom! September Move in!","location":"Hayward / castro valley","size":"1 bedrooms"},{"postingDate":"2015-08-22 10:28","url":"http://sfbay.craigslist.org/scz/apa/5185309172.html","price":"$1500","description":"Mountain Retreat","location":"Watsonville","size":"2 bedrooms"},{"postingDate":"2015-08-22 10:15","url":"http://sfbay.craigslist.org/sby/apa/5185283944.html","price":"$1929","description":"Charming Studio You'll Love!!!","location":"San jose west","size":"475 sqr fts."},{"postingDate":"2015-08-22 09:33","url":"http://sfbay.craigslist.org/eby/apa/5185193639.html","price":"$1875","description":"Large One Bedroom! Second Floor! Garden.","location":"Hayward / castro valley","size":"1 bedrooms"},{"postingDate":"2015-08-22 07:44","url":"http://sfbay.craigslist.org/sfc/apa/5185013357.html","price":"$1995","description":"Just Renovated! Nice Studio. Big Sun & .","location":"Downtown / civic / van ness","size":null},{"postingDate":"2015-08-22 07:01","url":"http://sfbay.craigslist.org/eby/apa/5184950443.html","price":"$2000","description":"OPEN HOUSE TODAY 1--4:30 PM","location":"Oakland east","size":"3 bedrooms"},{"postingDate":"2015-08-21 16:23","url":"http://sfbay.craigslist.org/nby/apa/5184338771.html","price":"$2100","description":"Charming Upscale Newly Remodelled Home","location":"Petaluma","size":"2 bedrooms"},{"postingDate":"2015-08-21 14:35","url":"http://sfbay.craigslist.org/eby/apa/5184175437.html","price":"$1950","description":"Brand New - New Chinatown (San Antonio .","location":"Oakland east","size":null},{"postingDate":"2015-08-21 14:32","url":"http://sfbay.craigslist.org/eby/apa/5184169807.html","price":"$1950","description":"Brand New - New Chinatown (San Antonio .","location":"Oakland east","size":"3 bedrooms"},{"postingDate":"2015-08-21 11:56","url":"http://sfbay.craigslist.org/eby/apa/5183929566.html","price":"$1875","description":"One Bedroom Coming Soon! Come Home to R.","location":"Hayward / castro valley","size":"1 bedrooms"},{"postingDate":"2015-08-21 10:53","url":"http://sfbay.craigslist.org/eby/apa/5183797363.html","price":"$1855","description":"Close to 880, San Mateo Bridge, BART, S.","location":"Hayward / castro valley","size":"1 bedrooms"},{"postingDate":"2015-08-21 09:50","url":"http://sfbay.craigslist.org/sby/apa/5183664907.html","price":"$1840","description":"Great Deal on Your New Apartment at Blo.","location":"San jose south","size":"1 bedrooms"},{"postingDate":"2015-08-21 09:14","url":"http://sfbay.craigslist.org/nby/apa/5183615523.html","price":"$1299","description":"$1299!DONT MISS THIS SWEET DEAL!!AVAILA.","location":"Santa rosa","size":"1 bedrooms"},{"postingDate":"2015-08-21 09:11","url":"http://sfbay.craigslist.org/eby/apa/5183608576.html","price":"$1875","description":"Large One Bedroom! Garden Style Communi.","location":"Hayward / castro valley","size":"1 bedrooms"},{"postingDate":"2015-08-20 17:45","url":"http://sfbay.craigslist.org/nby/apa/5182842512.html","price":"$1299","description":"Parc Station Your New Home! NEW REDUCED.","location":"Santa rosa","size":"1 bedrooms"},{"postingDate":"2015-08-20 14:56","url":"http://sfbay.craigslist.org/eby/apa/5182611416.html","price":"$1700","description":"Spacious, bright condo in quiet, gated .","location":"Hercules, pinole, san pablo, el sob","size":"2 bedrooms"},{"postingDate":"2015-08-19 18:20","url":"http://sfbay.craigslist.org/sby/apa/5181261423.html","price":"$1912","description":"Peaceful Courtyard View One Bedroom Apa.","location":"San jose west","size":"1 bedrooms"},{"postingDate":"2015-08-19 10:35","url":"http://sfbay.craigslist.org/nby/apa/5180492188.html","price":"$1299","description":"Looking for your next home sweet home?M.","location":"Santa rosa","size":"1 bedrooms"},{"postingDate":"2015-08-18 14:35","url":"http://sfbay.craigslist.org/sby/apa/5179252096.html","price":"$1929","description":"Charming Cozy Ground Floor Studio Comin.","location":"San jose west","size":"475 sqr fts."},{"postingDate":"2015-08-15 23:14","url":"http://sfbay.craigslist.org/eby/apa/5174986856.html","price":"$2000","description":"E. Oakland Craftsman Charmer-UPDATED","location":"Oakland east","size":"3 bedrooms"},{"postingDate":"2015-08-15 09:43","url":"http://sfbay.craigslist.org/nby/apa/5174020363.html","price":"$1550","description":"Excellent Location!","location":"San rafael","size":"1 bedrooms"},{"postingDate":"2015-08-22 12:29","url":"http://sfbay.craigslist.org/eby/apa/5185531645.html","price":"$1856","description":"Unbeatable Rates ~ Spacious wall to wal.","location":"Concord / pleasant hill / martinez","size":"2 bedrooms"},{"postingDate":"2015-08-22 10:21","url":"http://sfbay.craigslist.org/eby/apa/5185295677.html","price":"$1587","description":"Spacious ~ Pet Friendly ~ Gated Communi.","location":"Concord / pleasant hill / martinez","size":"1 bedrooms"},{"postingDate":"2015-08-22 09:37","url":"http://sfbay.craigslist.org/eby/apa/5185213772.html","price":"$2050","description":"Newly Renovated Standard 1x1, Top Floor.","location":"Dublin / pleasanton / livermore","size":"1 bedrooms"},{"postingDate":"2015-08-22 09:11","url":"http://sfbay.craigslist.org/sby/apa/5185166037.html","price":"$1995","description":"Remodeled Beautiful Townhouse walk to L.","location":"San jose north","size":"2 bedrooms"},{"postingDate":"2015-08-21 17:03","url":"http://sfbay.craigslist.org/eby/apa/5184390396.html","price":"$2050","description":"Newly Renovated Standard 1x1, Top Floor.","location":"Dublin / pleasanton / livermore","size":"1 bedrooms"},{"postingDate":"2015-08-21 16:10","url":"http://sfbay.craigslist.org/eby/apa/5184320628.html","price":"$2031","description":"Beautiful Renovated ~ Gated Community w.","location":"Concord / pleasant hill / martinez","size":"2 bedrooms"},{"postingDate":"2015-08-21 09:49","url":"http://sfbay.craigslist.org/eby/apa/5183684344.html","price":"$1587","description":"Amazing Gated Community ~ Spacious ~ Cl.","location":"Concord / pleasant hill / martinez","size":"1 bedrooms"},{"postingDate":"2015-08-20 19:09","url":"http://sfbay.craigslist.org/nby/apa/5174179892.html","price":"$1549","description":"HIGH ATOP SONOMA MOUNTAIN","location":"Petaluma","size":"1 bedrooms"},{"postingDate":"2015-08-20 14:04","url":"http://sfbay.craigslist.org/eby/apa/5182527421.html","price":"$1841","description":"Amazing Top Floor ~ All New Carpet Avai.","location":"Concord / pleasant hill / martinez","size":"2 bedrooms"},{"postingDate":"2015-08-20 11:00","url":"http://sfbay.craigslist.org/eby/apa/5182189397.html","price":"$1811","description":"Pool Side View ~Spacious Living Area Im.","location":"Concord / pleasant hill / martinez","size":"1 bedrooms"},{"postingDate":"2015-08-20 10:33","url":"http://sfbay.craigslist.org/eby/apa/5182136307.html","price":"$1989","description":"1x1 TOP FLOOR, AMAZING NEW APPLIANCES (.","location":"Dublin / pleasanton / livermore","size":"1 bedrooms"},{"postingDate":"2015-08-18 09:30","url":"http://sfbay.craigslist.org/eby/apa/5178653183.html","price":"$1899","description":"2nd Floor Studio Available IMMEDIATELY .","location":"Dublin / pleasanton / livermore","size":"1 bedrooms"},{"postingDate":"2015-08-17 17:44","url":"http://sfbay.craigslist.org/nby/apa/5177820316.html","price":"$2098","description":"2BR/1BA Apartment with Central Heat and.","location":"Petaluma","size":"2 bedrooms"},{"postingDate":"2015-08-17 17:28","url":"http://sfbay.craigslist.org/eby/apa/5177798259.html","price":"$1899","description":"2nd Floor Studio Available IMMEDIATELY!!","location":"Dublin / pleasanton / livermore","size":"1 bedrooms"},{"postingDate":"2015-08-16 10:35","url":"http://sfbay.craigslist.org/eby/apa/5175501461.html","price":"$2050","description":"Lovely One Bedroom Unit Available To Mo.","location":"Dublin / pleasanton / livermore","size":"1 bedrooms"},{"postingDate":"2015-08-15 10:40","url":"http://sfbay.craigslist.org/eby/apa/5174127064.html","price":"$1100","description":"Apartment On 8 Unit Gated Community - F.","location":"Fairfield / vacaville","size":"2 bedrooms"},{"postingDate":"2015-08-15 00:35","url":"http://sfbay.craigslist.org/eby/apa/5173524679.html","price":"$2100","description":"Completely remodelled Vacaville home w .","location":"Fairfield / vacaville","size":"3 bedrooms"},{"postingDate":"2015-08-20 08:57","url":"http://sfbay.craigslist.org//sacramento.craigslist.org/apa/5181947484.html","price":"$1082","description":"Three Bedroom for Rent - TODAY!","location":null,"size":"3 bedrooms"},{"postingDate":"2015-08-19 07:39","url":"http://sfbay.craigslist.org//sacramento.craigslist.org/apa/5174909189.html","price":"$1580","description":"Amazing 4 Bd 2.5 Ba Antelope Home for R.","location":"Sac > Antelope","size":"4 bedrooms"},{"postingDate":"2015-08-18 21:05","url":"http://sfbay.craigslist.org//modesto.craigslist.org/apa/5179746783.html","price":"$1000","description":"House For Rent","location":"Mod > Ripon","size":"2 bedrooms"},{"postingDate":"2015-08-22 16:23","url":"http://sfbay.craigslist.org//sacramento.craigslist.org/apa/5185856766.html","price":"$1325","description":"Large Dogs Up To 75 lbs With No Pet Ren.","location":"Sac > Citrus Heights","size":"2 bedrooms"},{"postingDate":"2015-08-22 09:38","url":"http://sfbay.craigslist.org//goldcountry.craigslist.org/apa/5185216951.html","price":"$1200","description":"Indian Peak Rd - House for Rent (3bd/2b.","location":null,"size":"3 bedrooms"},{"postingDate":"2015-08-21 14:28","url":"http://sfbay.craigslist.org//sacramento.craigslist.org/apa/5184106018.html","price":"$995","description":"Sunny 2Bd/1Ba Full Size W/D Ready to Re.","location":"Sac > Sacramento, CA","size":"2 bedrooms"},{"postingDate":"2015-08-13 14:26","url":"http://sfbay.craigslist.org//modesto.craigslist.org/apa/5171316610.html","price":"$1550","description":"Large Home for Rent in Ceres! 9/10/15","location":"Mod > next to Sam Vaughn","size":"4 bedrooms"},{"postingDate":"2015-08-22 15:48","url":"http://sfbay.craigslist.org//sacramento.craigslist.org/apa/5185835046.html","price":"$2055","description":"Special Today - Reduced Deposit & No Ap.","location":"Sac > 1451 Rocky Ridge Drive","size":"3 bedrooms"},{"postingDate":"2015-08-22 15:43","url":"http://sfbay.craigslist.org//sacramento.craigslist.org/apa/5185802783.html","price":"$1160","description":"Spacious, Affordable and Available Now .","location":"Sac > Sacramento, CA","size":"2 bedrooms"}];
app.controller('apartmentFinderController', function($scope, $http, $filter) {
	$scope.showDataGrid = false;
	$scope.dataLoading = false;
	$scope.showError = false;
	$scope.bathroomsList = [ { value :'',text : "All bathrooms"}, {value : 1,text : "1+ bathrooms"}, {value : 2,text : "2+ bathrooms"}, {value : 3,text : "3+ bathrooms"}, 
	                         { value : 4,text : "4+ bathrooms"}, {value : 5,text : "5+ bathrooms"},{value : 6,text : "6+ bathrooms"},{value : 7,text : "7+ bathrooms"},{value : 8,text : "8+ bathrooms"} ];

	$scope.bedroomsList = [ { value :'',text : "All bedrooms"}, {value : 1,text : "1+ bedrooms"}, {value : 2,text : "2+ bedrooms"}, {value : 3,text : "3+ bedrooms"}, 
	                         { value : 4,text : "4+ bedrooms"}, {value : 5,text : "5+ bedrooms"},{value : 6,text : "6+ bedrooms"},{value : 7,text : "7+ bedrooms"},{value : 8,text : "8+ bedrooms"} ];

	$scope.rentControls= [ { value : true , text : 'Yes'},{value : false , text : 'No'}];
	
	$scope.apartmentSearch = {};
	$scope.apartmentSearch.apartMentType = $scope.bedroomsList[0];
	
	$scope.apartmentSearch.numberOfBathrooms = $scope.bathroomsList[0];
	
	$scope.apartmentSearch.rentControlled = $scope.rentControls[1];
	
	$http.get('js/CraigListSites.json').success(function(response) {
		$scope.cities = response;
		var foundObject = getByProperty('city', 'San Francisco', $scope.cities);
		$scope.apartmentSearch.selectedCity = foundObject;
    });
	
	$scope.clearForm = function(){
		$scope.startingRecordCount = 0;
		$scope.endingRecordCount = 0;
		$scope.showDataGrid  = false;
		$scope.results = [];
		$scope.totalRecords = [];
		$scope.showNoRecords = false;
		$scope.showError = false;
		$scope.currentPage = 0;
	}
	
	
	$scope.submitForm = function(isValid,resetSearchFilter){
			if(isValid){
				if(resetSearchFilter){
					$scope.nextPageUrl = null;
				}
				$scope.clearForm();
				if($scope.apartmentSearch.maxCost < $scope.apartmentSearch.minCost){
					alert("Maximum rent should be greater than minimum rent");
					return;
				}
				
				
				$scope.dataLoading = true;
				
//				console.log(angular.toJson($scope.apartmentSearch));
				var apartmentSearchObj = {
						'selectedCityCraiglistUrl':$scope.apartmentSearch.selectedCity.url,
						'apartmentType' :$scope.apartmentSearch.apartMentType.value,
						'numberOfBathrooms' :$scope.apartmentSearch.numberOfBathrooms.value,
						'minCost' :$scope.apartmentSearch.minCost,
						'maxCost' :$scope.apartmentSearch.maxCost,
						'emailId' :$scope.apartmentSearch.emailId,
						'rentControlled' : $scope.apartmentSearch.rentControlled.value,
						'nextPageUrl' :$scope.nextPageUrl
				};
//				console.log(angular.toJson(apartmentSearchObj));
				   $http({
		               url: '/rentalApartments',
		               data: angular.toJson(apartmentSearchObj),
		               transformResponse:[function(data){return data;}],
		               method: 'POST',
		               headers: {
		                 'Content-Type': 'application/json'
		               }
		             }).success(function(data) {
		            	 		$scope.dataLoading = false;
			            	 	if (data != null) {
				                	var responseObj = angular.fromJson(data);
				                	if(responseObj.status == 'SUCCESS'){
				                		
				                		if(responseObj.apartmentSearchResponse == null || responseObj.apartmentSearchResponse.length ==0){
				                			$scope.clearForm();
				                			$scope.nextPageUrl = null;
				                			$scope.showNoRecords = true;
				                		}else{
				                			$scope.showNoRecords = false;
				                			$scope.showDataGrid = true;
				                			$scope.startingRecordCount = responseObj.startingRecordCount;
				                			$scope.endingRecordCount = responseObj.endingRecordCount;
				                			$scope.results = responseObj.apartmentSearchResponse;
					                		$scope.totalRecords = responseObj.totalRecordsCount;
					                		$scope.nextPageUrl = responseObj.nextPageUrl;
					                		$scope.currentPage = 0;
				                		}
				                		
				                	}else{
				                		$scope.nextPageUrl = null;
				                		$scope.showDataGrid  = false;
				                		$scope.showError = true;
				                	}
			            	 	}else{
			            	 		$scope.nextPageUrl = null;
			            	 		$scope.showDataGrid  = false;
			            	 		$scope.showError = true;
			                        
			            	 	}	
		             }).error(function(data) {
		            	$scope.dataLoading = false;
		               $scope.showDataGrid  = false;
		               $scope.showError = true
		             });
			   
			}else{
			
		}
	};
		$scope.startingRecordCount = 0;
		$scope.endingRecordCount = 0;
	  	$scope.currentPage = 0;
	    $scope.pageSize = 10;
	    $scope.results = [];
	    $scope.totalRecords = 0;
	    $scope.numberOfPages=function(){
	        return Math.ceil($scope.results.length/$scope.pageSize);                
	    }
	    $scope.nextPageUrl = null;
	    
	    $scope.isLastPage=  function(){
	    	var cond = ($scope.currentPage >= $scope.results.length/$scope.pageSize - 1) && ($scope.nextPageUrl != null);
			return cond;
	    };


	function getByProperty (propertyName, propertyValue, collection) {
		var i=0, len=collection.length;
		for (; i<len; i++) {
			if (collection[i][propertyName] == propertyValue) {
				return collection[i];
			}
		}
		return null;
	};


});

app.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});