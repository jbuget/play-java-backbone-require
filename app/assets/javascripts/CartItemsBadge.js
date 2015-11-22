define([
    'jquery',
    'underscore'
], function ($, _) {

    'use strict';

    function fetchCartItems(callback) {
        $.ajax({
            url:'/cart/items',
            type:'GET',
            dataType:"json",
            success:function (data) {
                if (data.error) {
                    console.error('An error occurred: ' + data.error.text);
                }
                callback(data);
            }
        });
    }

    function displayCartItemsBadge(selector) {
        fetchCartItems(function (data) {
            var $el = $(selector),
                html = '<span class="badge cart-items-badge"><%= nbItems %></span>';
            var template = _.template(html);
            $el.replaceWith(template({nbItems: data.length}));
        });
    }

    function updateCartItemsBadge() {
        fetchCartItems(function (data) {
            var $badge = $('.cart-items-badge');
            var nbItems = data.length;
            $badge.html(nbItems);
        });
    }

    return {
        display: displayCartItemsBadge,
        update: updateCartItemsBadge
    };

});