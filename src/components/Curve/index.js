import React from 'react';

export default class Curve extends React.Component {
	constructor(props) {
		super(props);
		this.css = {
			position: 'absolute',
			top: '115px',
			left: '250px'
		}
	}
	showCurve() {
		if (!this.props.possiblePoints)
			return false;
		if (!this.props.targetPercentage)
			return false;
		if (!this.props.scores.length == 0)
		return true;
	}
	getCurve() {
		let pp = +this.props.possiblePoints;
		let tp = +this.props.targetPercentage;
		let scores = this.props.scores;

		let ts = pp * (tp/100);
		let sum = 0;
		for (let i = 0; i < scores.length; i++) {
			sum += +scores[i];
		}
		let as = sum / scores.length;
		let curve = Math.ceil(ts - as);
		if (curve > 0) {
			return curve;
		}
		return 0;
	}
	render() {
		return (
			<div className="curve" style={this.css}>
				{!this.showCurve() ? null :
					<span>
						Add <b>{this.getCurve()}</b> point(s) to each test score.
					</span>
				}
			</div>
		);
	}
}
