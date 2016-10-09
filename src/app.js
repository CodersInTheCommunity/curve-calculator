import React from 'react';
import ReactDOM from 'react-dom';
import update from 'react-addons-update';

import PossiblePoints from './components/PossiblePoints';
import TargetPercentage from './components/TargetPercentage'
import Input from './components/Input';
import Scores from './components/Scores';
import Curve from './components/Curve';

export default class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			possiblePoints: '',
			targetPercentage: '',
			scores: []
		}
	}
	setPossiblePoints(value) {
		this.setState({
			possiblePoints: value
		});
	}
	setTargetPercentage(value) {
		this.setState({
			targetPercentage: value
		});
	}
	addScore(score) {
		this.setState({
			scores: this.state.scores.concat([score])
		});
	}
	removeScore(i) {
		this.setState({
			scores: update(this.state.scores, {$splice: [[i, 1]]})
		});
	}
	render() {
		return(
			<div className="app-container">
				<h1>Curve Calculator</h1>
				<PossiblePoints
					value={this.state.possiblePoints}
					setValue={this.setPossiblePoints.bind(this)} />
				<br/>
				<TargetPercentage
					value={this.state.targetPercentage}
					setValue={this.setTargetPercentage.bind(this)} />
				<br/>
				<Input
					addScore={this.addScore.bind(this)} />
				<br/>
				<Scores
					scores={this.state.scores}
					removeScore={this.removeScore.bind(this)} />
				<Curve
					possiblePoints={this.state.possiblePoints}
					targetPercentage={this.state.targetPercentage}
					scores={this.state.scores} />
			</div>
		);
	}
}

ReactDOM.render(
	<App />, document.getElementById('app')
);
