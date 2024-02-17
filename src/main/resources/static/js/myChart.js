const ctx = document.getElementById("myPieChart");

new Chart(ctx, {
	type: 'pie',
	data: {
		datasets: [{
			label: '# of Votes',
			data: [12, 19, 3, 5, 2, 3],
			borderWidth: 1
  		}]
	},
	options: {
	responsive: true,
	plugins: {
		legend: {
			position: 'top',
		},
		title: {
			display: true,
			text: 'Pie Chart'
		}
	}
},
});