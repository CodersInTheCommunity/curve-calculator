import React from 'react';

export default class Scores extends React.Component {
	constructor(props) {
		super(props);
	}
	handleClick(i, e) {
		this.props.removeScore(i);
	}
	render() {
		return(
			<div className="scores">
				{!this.props.scores.length ? null :
					<i>(Click on a score to remove it)</i>
				}
				<ul>
				{this.props.scores.map(function(score, i){
					return(
						<li key={i}>
							<span
								style={{cursor:'pointer'}}
								onClick={this.handleClick.bind(this, i)}>
								{score}
							</span>
						</li>
					);
	  			}.bind(this))}
				</ul>
			</div>
		);
	}
}
