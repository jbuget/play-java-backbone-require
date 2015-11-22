requirejs.config({
    baseUrl : '/assets/javascripts',
    paths: {
        'jquery': '../lib/jquery/jquery.min',
        'bootstrap': '../lib/bootstrap/js/bootstrap.min',
        'underscore': '../lib/underscorejs/underscore-min',
        'backbone': '../lib/backbonejs/backbone-min',
        'pace': '../lib/pace/pace.min'
    }
});

require([
    'jquery',
    'pace',
    'common',
    'CartItemsBadge'
], function ($, pace, common, CartItemsBadge) {
    'use strict';
    pace.start();
    CartItemsBadge.display('#cart-items-badge');
});