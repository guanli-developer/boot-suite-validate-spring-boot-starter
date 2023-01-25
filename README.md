[TOC]
# Overview
This component is help to validate request parameters, the parameter types supported are query string, request body, variable path.
# How to use
Just use spring validate annotation.

## Default handler
Component has a default exception handler to catch validate exception and convert them to `tech.guanli.boot.internal.model.implemention.ResponseData`, if you want to do it yourself, you can make your handler and close the default handler by set `tech.guanli.boot.validate.enable-default-handler` = **_false_**