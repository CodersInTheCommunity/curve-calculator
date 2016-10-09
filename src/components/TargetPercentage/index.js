import React from 'react';

export default class TargetPercentage extends React.Component {
	constructor(props) {
		super(props);
		this.css = {
			width: '30px'
		}
	}
	handleChange(e) {
		let nonNumericRegex = /[^0-9.]+/g;
		let value = e.target.value.replace(nonNumericRegex, '');
		if (value <= 100)
			this.props.setValue(value);
	}
	render() {
		return(
			<div className="target">
				<label>Target Percentage: </label>
				<input
					type="text"
					value={this.props.value}
					onChange={this.handleChange.bind(this)}
					style={this.css} />
			</div>
		);
	}
}
