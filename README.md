# `sinfo`

A thin wrapper around the [javasysmon library](https://github.com/jezhumble/javasysmon.com) that provides information about the system the application is running on. 

## Usage

You will need to download the [jar](http://continuousdelivery.com/downloads/javasysmon/javasysmon-0.3.4.jar) and install it locally via Maven in order to use this library.

```bash
>mkdir repo
>mvn install:install-file -DgroupId=local -DartifactId=javasysmon \
    -Dversion=0.3.4 -Dpackaging=jar -Dfile=javasysmon-0.3.4.jar \
    -DlocalRepositoryPath=repo
```

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

Ability to kill processes

```clojure
> (kill 5981)
nil
```

Kills the process tree inclusively beginning at pid

```clojure
>(kill-tree 5981 true) 
nil
```

Kills all descendents of the currently running process

```clojure
>(infanticide) 
nil
```

Returns a list of all the processes that are currently running

```clojure
>(processes)
(#sinfo.core.Proc{:name "", :command "", :owner "", :parent , :pid , :physical-bytes , :total-bytes , :user-ms , :kernel-ms , :host ""})
```
