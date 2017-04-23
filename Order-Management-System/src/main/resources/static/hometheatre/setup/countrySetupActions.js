/*<![CDATA[*/
		$("#btnUpdate").hide();
		$("#btnSave").click(
				function() {
					if ($("#countryName").val() == ""
							|| $("#countryName").val() == null) {
						$("#lblStatus").text('Please enter country name');
					} else {
						saveCountry(0, $("#countryName").val());
					}
				});

		$("#btnUpdate").click(
				function() {
					if ($("#countryName").val() == ""
							|| $("#countryName").val() == null) {
						$("#lblStatus").text('Please enter competencies name');
					} else {
						saveCountry($("#countryId").val(), $("#countryName")
								.val());
					}
				});

		$("#btnCancel").click(function() {
			$("#btnUpdate").hide();
			$("#btnSave").show();
			$("#countryId").val('');
			$("#countryName").val('');
			$("#lblStatus").text('');
		});

		$("#countryName").keypress(function() {
			$("#lblStatus").text('');
		});

		function saveCountry(id, countryName) {

			$.ajax({
				url : "/hometheatre/setup/country/saveCountry",
				type : "POST",
				dataType : 'json',
				data : {
					"id" : id,
					"countryName" : countryName
				},
				success : function(data) {
					$.each(data, function(index, element) {
						$("#lblStatus").text(element.status);
						//$("#tblCompetencies").load( "appraisalCompetencies #tblCompetencies");
						if ($("#lblStatus").text() != "Name already exists") {
							$("#countryId").val('');
							$("#countryName").val('');
							//location.reload();
							//reloadCountryList();
							$("#tblCountry").load("country #tblCountry");
						}
					});
				},
				error : function() {
					alert("Error Occured!");
				}
			});

		}
		function reloadCountryList() {
			$.ajax({
				url : "/setup/country/countryList",
				type : "POST",
				dataType : 'json',
				data : {},
				success : function(data) {
					alert(data);
					$("#countryListContainer").html(data);
				},
				error : function() {
					alert('Error Occured!');
				}
			});
		}
		function getCountryInfo(event) {

			var id = event.target.id;

			$.ajax({
				url : "/setup/country/getCountry",
				type : "POST",
				dataType : 'json',
				data : {
					"id" : id
				},
				success : function(data) {
					$.each(data, function(index, element) {
						$("#countryId").val(element.id);
						$("#countryName").val(element.countryName);
						$('html, body').animate({
							scrollTop : '0px'
						}, 500);
					});
				},
				error : function() {
				}
			});

			$("#btnUpdate").show();
			$("#btnSave").hide();
		}
		/*]]>*/