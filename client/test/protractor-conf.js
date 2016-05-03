exports.config = {
  allScriptsTimeout: 11000,

  specs: [
    'e2e/*.js'
  ],
  chromeDriver: 'C:/Dev/agm/alma/automation-tests/chromedriver.exe',

  capabilities: {
    'browserName': 'chrome'
  },

  chromeOnly: true,

  baseUrl: 'http://localhost:8000/',

  framework: 'jasmine',

  jasmineNodeOpts: {
    defaultTimeoutInterval: 30000
  }
};
