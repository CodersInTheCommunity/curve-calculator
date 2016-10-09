import React from 'react';

export default class Input extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			value: ''
		}
	}
	handleChange(e) {
		let nonNumericRegex = /[^0-9.]+/g;
		this.setState({
			value: e.target.value.replace(nonNumericRegex, '')
		});
	}
	handleKeyPress(e) {
		let score = this.state.value;
		if (e.key === 'Enter' && score != '') {
			this.props.addScore(score);
			this.setState({
				value: ''
			});
		}
	}
	render() {
		return(
			<div className="input">
				<label>Enter a score: </label>
				<input
					type="text"
					value={this.state.value}
					onChange={this.handleChange.bind(this)}
					onKeyPress={this.handleKeyPress.bind(this)} />
			</div>
		);
	}
}
