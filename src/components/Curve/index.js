import React from 'react';

export default class Curve extends React.Component {
	constructor(props) {
		super(props);
	}
	showCurve() {
		if (!this.props.possiblePoints)
			return false;
		if (!this.props.targetPercentage)
			return false;
		return true;
	}
	getCurve() {
		return this.props.possiblePoints - this.props.targetPercentage;
	}
	render() {
		return (
			<div className="curve">
				{!this.showCurve() ? null :
					this.getCurve()
				}
			</div>
		);
	}
}
