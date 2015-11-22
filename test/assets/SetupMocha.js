// Setup requirejs to have the right baseUrl
global.requirejs = require("requirejs");

requirejs.config({
    nodeRequire: require,
    baseUrl: __dirname,
    paths: {
        'catalog': 'javascripts/catalog',
        'cart': 'javascripts/cart',
        'jquery': 'lib/jquery/jquery',
        'bootstrap': 'lib/bootstrap/dist/js/bootstrap',
        'underscore': 'lib/underscorejs/underscore',
        'backbone': 'lib/backbonejs/backbone'
    }
});

// A few modules that all tests will use
//global.jquery = requirejs('jquery');
global.assert = require("assert");
global.chai = require("chai");


