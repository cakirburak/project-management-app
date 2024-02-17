const ctx = document.getElementById("myPieChart");

var chartDataStr = decodeHtml(chartData);
var chartDataJson = JSON.parse(chartDataStr)

var numericData = []
var labelData = []

for(let i = 0; i < chartDataJson.length ; i++){
	numericData[i] = chartDataJson[i].pidCount
	labelData[i] = chartDataJson[i].projectStage
}

console.log(numericData)
console.log(labelData)


new Chart(ctx, {
	type: 'pie',
	data: {
		labels: labelData,
		datasets: [{
			label: '',
			data: numericData,
			borderWidth: 1,
			backgroundColor: [
				'rgb(54, 162, 235)',
				'rgb(255, 205, 86)',
				'rgb(255, 99, 132)',
			]
  		}]
	},
	options: {
		title: {
			display: true,
			text: 'Project Statuses'
		}
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value
}