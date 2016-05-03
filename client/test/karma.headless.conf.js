module.exports = function(config){
  config.set({

    basePath : '../',
	preprocessors : {
		'**/*.js': 'coverage'
	},
	
    files : [
      'app/bower_components/angular/angular.js',
      'app/bower_components/angular-route/angular-route.js',
      'app/bower_components/angular-resource/angular-resource.js',
      'app/bower_components/angular-animate/angular-animate.js',
      'app/bower_components/angular-mocks/angular-mocks.js',
      'app/js/**/*.js',
      'test/unit/**/*.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['PhantomJS'],
	
	reporters : ['junit','coverage'],
	
    plugins : [
            'karma-chrome-launcher',
            'karma-phantomjs-launcher',
            'karma-firefox-launcher',
            'karma-junit-reporter',
            'karma-coverage',
            'karma-jasmine'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    },
	
	coverageReporter : {
		type : 'cobertura',
		dir : 'test_out/',
		file : 'coverage.xml'
	}
	

  });
};