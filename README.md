# `sinfo`

[![Build Status](https://travis-ci.org/andrewhavck/sinfo.png?branch=master)](https://travis-ci.org/andrewhavck/sinfo)

A thin wrapper around a [Java system library](https://github.com/jezhumble/javasysmon.com) that provides information about the system the application is running on.

## Usage

```clojure
[sinfo "0.1.0"]
```

Check if the platform is supported.

```clojure
> (supported?)
true
```

OS Info

```clojure
> (os-name?)
"Mac OS X 10.9.1"
```

## License