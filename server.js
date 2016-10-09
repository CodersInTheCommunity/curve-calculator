var webpack = require('webpack');
var WebpackDevServer = require('webpack-dev-server');

var config = require('./config/webpack.config.js');

var port = 3000;
var ip = '0.0.0.0';
new WebpackDevServer(webpack(config), {
	stats: { colors: true },
    publicPath: config.output.publicPath,
    historyApiFallback: {
    	index: 'dev.html'
    }
}).listen(port, ip, function (err) {
    if(err) {
        return console.log(err);
    }
	console.log('Proxy started at http://localhost:' + port);
});
