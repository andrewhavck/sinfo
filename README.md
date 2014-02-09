# `sinfo`

[![Build Status](https://travis-ci.org/andrewhavck/sinfo.png?branch=master)](https://travis-ci.org/andrewhavck/sinfo)

A thin wrapper around a [Java system library](https://github.com/jezhumble/javasysmon.com) that provides information about the system the application is running on. You will need to download the [jar](http://continuousdelivery.com/downloads/javasysmon/javasysmon-0.3.4.jar)

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

Number of cpus

```clojure
> (num-cpus)
4
```

Cpu frequency in Hz

```clojure
> (cpu-freq-hz)
2900000000
```

Uptime in seconds

```clojure
> (uptime-sec)
515895
```
