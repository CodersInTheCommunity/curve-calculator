import React from 'react';

export default class Input extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			value: ''
		}
		this.css = {
			width: '30px'
		}
	}
	handleChange(e) {
		let nonNumericRegex = /[^0-9.]+/g;
		this.setState({
			value: e.target.value.replace(nonNumericRegex, '')
		});
	}
	handleKeyPress(e) {
		if (e.key === 'Enter' && this.state.value != '') {
			this.props.addScore(this.state.value);
			this.setState({
				value: ''
			});
		}
	}
	handleClick(e) {
		if (this.state.value != '') {
			this.props.addScore(this.state.value);
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
					onKeyPress={this.handleKeyPress.bind(this)}
					style={this.css} />
				<button onClick={this.handleClick.bind(this)}>+</button>
			</div>
		);
	}
}
