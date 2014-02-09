# `sinfo`

A thin wrapper around a [Java system library](https://github.com/jezhumble/javasysmon.com) that provides information about the system the application is running on. You will need to download the [jar](http://continuousdelivery.com/downloads/javasysmon/javasysmon-0.3.4.jar)

## Usage

```clojure
[sinfo "0.1.0"]
```

Various functions

```clojure
> (supported?)
true

> (os-name?)
"Mac OS X 10.9.1"

> (num-cpus)
4

> (cpu-freq-hz)
2900000000

> (uptime-sec)
515895

> (curr-pid)
22376

> (physical)
{:free 2379927552, :total 8589934592}

> (swap)
{:free 1073741824, :total 1073741824}
```
