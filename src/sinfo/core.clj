(ns sinfo.core
  (:import [com.jezhumble.javasysmon JavaSysMon ProcessInfo]
           [java.net InetAddress]))

(defprotocol ProcInfo
  (name [this])
  (command [this])
  (owner [this])
  (parent [this])
  (pid [this])
  (physical-bytes [this])
  (total-bytes [this])
  (user-ms [this])
  (kernel-ms [this])
  (host [this]))

(defrecord Proc [name
                 command
                 owner
                 parent
                 pid
                 physical-bytes
                 total-bytes
                 user-ms
                 kernel-ms
                 host]
  ProcInfo
  (name [this] (:name this))
  (command [this] (:command this))
  (owner [this] (:owner this))
  (parent [this] (:parent this))
  (pid [this] (:pid this))
  (physical-bytes [this] (:physical-bytes this))
  (total-bytes [this] (:total-bytes this))
  (user-ms [this] (:user-ms this))
  (kernel-ms [this] (:kernel-ms this))
  (host [this] (:host this)))

(defn supported? [] (.supportedPlatform (JavaSysMon.)))

(defn os-name [] (.osName (JavaSysMon.)))

(defn num-cpus [] (.numCpus (JavaSysMon.)))

(defn cpu-freq-hz [] (.cpuFrequencyInHz (JavaSysMon.)))

(defn uptime-sec [] (.uptimeInSeconds (JavaSysMon.)))

;Return pid of calling method
(defn curr-pid [] (.currentPid (JavaSysMon.)))

; Snapshot that contains the total amount of time the CPU has spent in
; user mode, kernel mode, and idle.
;
; Given two snapshots you can calculate CPU usage during that time.
(defn cpu-usage [window]
  (let [snapshot (.cpuTimes (JavaSysMon.))]
    (do
      (Thread/sleep window)
      (.getCpuUsage (.cpuTimes (JavaSysMon.)) snapshot))))

(defn physical [] (.physical (JavaSysMon.)))

(defn- mem-stats [snapshot] {:free (.getFreeBytes snapshot) :total (.getTotalBytes snapshot)})

(defn swap [] (mem-stats (.swap (JavaSysMon.))))

(defn physical [] (mem-stats (.physical (JavaSysMon.))))

(defn kill [pid] (.killProcess (JavaSysMon.) pid))

(defn processes []
  (let [procs (seq (.processTable (JavaSysMon.)))
        localhost (InetAddress/getLocalHost)
        hostname (str (.getHostName localhost) "@" (.getHostAddress localhost))]
          (map (fn [obj]
                 (Proc.
                  (.getName obj)
                  (.getCommand obj)
                  (.getOwner obj)
                  (.getParentPid obj)
                  (.getPid obj)
                  (.getResidentBytes obj)
                  (.getTotalBytes obj)
                  (.getSystemMillis obj)
                  (.getUserMillis obj)
                  hostname)) procs)))

; Kills the process tree beginning at pid. 
(defn kill-tree [pid inclusive?] (.killProcessTree pid inclusive? (JavaSysMon.)))

; Kills all descendants of the currently running process
(defn infanticide [] (.infanticide (JavaSysMon.)))