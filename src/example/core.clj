;; 
;; CIDER's version (0.16.0-snapshot)
;; lein version Leiningen 2.8.0 on Java 1.8.0_144 OpenJDK 64-Bit Server VM
;; Host is Manjaro Linux
;;
(ns example.core
  (:require [fn-fx.fx-dom :as dom]
            [fn-fx.diff :refer [component defui render should-update?]]
            [fn-fx.controls :as ui]))

(def firebrick
  (ui/color :red 0.69 :green 0.13 :blue 0.13))

;; The main login window component, notice the authed? parameter, this defines a function
;; we can use to construct these ui components, named "login-form"
(defui LoginWindow
  (render [this {:keys [authed?]}]
    (ui/grid-pane
      :alignment :center
      :hgap 10
      :vgap 10
      :padding (ui/insets
                 :bottom 25
                 :left 25
                 :right 25
                 :top 25)
      :children [(ui/text
                   :text "Welcome"
                   :font (ui/font
                           :family "Tahoma"
                           :weight :normal
                           :size 20)
                   :grid-pane/column-index 0
                   :grid-pane/row-index 0
                   :grid-pane/column-span 2
                   :grid-pane/row-span 1)

                 (ui/label
                   :text "User:"
                   :grid-pane/column-index 0
                   :grid-pane/row-index 1)

                 (ui/text-field
                   :id :user-name-field
                   :grid-pane/column-index 1
                   :grid-pane/row-index 1)

                 (ui/label :text "Password:"
                   :grid-pane/column-index 0
                   :grid-pane/row-index 2)

                 (ui/password-field
                   :id :password-field
                   :grid-pane/column-index 1
                   :grid-pane/row-index 2)

                 (ui/h-box
                   :spacing 10
                   :alignment :bottom-right
                   :children [(ui/button :text "Sign in"
                                :on-action {:event :auth
                                            :fn-fx/include {:user-name-field #{:text}
                                                            :password-field #{:text}}})]
                   :grid-pane/column-index 1
                   :grid-pane/row-index 4)

                 (ui/text
                   :text (if authed? "Sign in was pressed" "")
                   :fill firebrick
                   :grid-pane/column-index 1
                   :grid-pane/row-index 6)])))
;; !!! (ui/text  is error ...

;;   Show: Project-Only All 
;;   Hide: Clojure Java REPL Tooling Duplicates  (90 frames hidden)

;; 2. Unhandled clojure.lang.Compiler$CompilerException
;;    Error compiling src/getting_started/02_form.clj at (62:18)

;;              Compiler.java: 6688  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3827  clojure.lang.Compiler$InvokeExpr/parse
;;              Compiler.java: 6870  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3834  clojure.lang.Compiler$InvokeExpr/parse
;;              Compiler.java: 6870  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3834  clojure.lang.Compiler$InvokeExpr/parse
;;              Compiler.java: 6870  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 6868  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6856  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3072  clojure.lang.Compiler$MapExpr/parse
;;              Compiler.java: 6677  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3834  clojure.lang.Compiler$InvokeExpr/parse
;;              Compiler.java: 6870  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6856  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3228  clojure.lang.Compiler$VectorExpr/parse
;;              Compiler.java: 6671  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3072  clojure.lang.Compiler$MapExpr/parse
;;              Compiler.java: 6677  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 3834  clojure.lang.Compiler$InvokeExpr/parse
;;              Compiler.java: 6870  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6856  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 6319  clojure.lang.Compiler$LetExpr$Parser/parse
;;              Compiler.java: 6868  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 8262  clojure.lang.Compiler$NewInstanceMethod/parse
;;              Compiler.java: 7798  clojure.lang.Compiler$NewInstanceExpr/build
;;              Compiler.java: 7678  clojure.lang.Compiler$NewInstanceExpr$DeftypeParser/parse
;;              Compiler.java: 6868  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 6319  clojure.lang.Compiler$LetExpr$Parser/parse
;;              Compiler.java: 6868  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 6319  clojure.lang.Compiler$LetExpr$Parser/parse
;;              Compiler.java: 6868  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6856  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 6319  clojure.lang.Compiler$LetExpr$Parser/parse
;;              Compiler.java: 6868  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6625  clojure.lang.Compiler/analyze
;;              Compiler.java: 6001  clojure.lang.Compiler$BodyExpr$Parser/parse
;;              Compiler.java: 5380  clojure.lang.Compiler$FnMethod/parse
;;              Compiler.java: 3972  clojure.lang.Compiler$FnExpr/parse
;;              Compiler.java: 6866  clojure.lang.Compiler/analyzeSeq
;;              Compiler.java: 6669  clojure.lang.Compiler/analyze
;;              Compiler.java: 6924  clojure.lang.Compiler/eval
;;              Compiler.java: 6890  clojure.lang.Compiler/eval
;;                   core.clj: 3105  clojure.core/eval
;;                   core.clj: 3101  clojure.core/eval
;;              enlighten.clj:   86  cider.nrepl.middleware.enlighten/eval-with-enlighten
;;              enlighten.clj:   80  cider.nrepl.middleware.enlighten/eval-with-enlighten
;;                   Var.java:  379  clojure.lang.Var/invoke
;;                   main.clj:  240  clojure.main/repl/read-eval-print/fn
;;                   main.clj:  240  clojure.main/repl/read-eval-print
;;                   main.clj:  258  clojure.main/repl/fn
;;                   main.clj:  258  clojure.main/repl
;;                   main.clj:  174  clojure.main/repl
;;                RestFn.java:  137  clojure.lang.RestFn/applyTo
;;                   core.clj:  646  clojure.core/apply
;;                   core.clj:  641  clojure.core/apply
;;                 regrow.clj:   18  refactor-nrepl.ns.slam.hound.regrow/wrap-clojure-repl/fn
;;                RestFn.java: 1523  clojure.lang.RestFn/invoke
;;     interruptible_eval.clj:   87  clojure.tools.nrepl.middleware.interruptible-eval/evaluate/fn
;;                   AFn.java:  152  clojure.lang.AFn/applyToHelper
;;                   AFn.java:  144  clojure.lang.AFn/applyTo
;;                   core.clj:  646  clojure.core/apply
;;                   core.clj: 1881  clojure.core/with-bindings*
;;                   core.clj: 1881  clojure.core/with-bindings*
;;                RestFn.java:  425  clojure.lang.RestFn/invoke
;;     interruptible_eval.clj:   85  clojure.tools.nrepl.middleware.interruptible-eval/evaluate
;;     interruptible_eval.clj:   55  clojure.tools.nrepl.middleware.interruptible-eval/evaluate
;;     interruptible_eval.clj:  222  clojure.tools.nrepl.middleware.interruptible-eval/interruptible-eval/fn/fn
;;     interruptible_eval.clj:  190  clojure.tools.nrepl.middleware.interruptible-eval/run-next/fn
;;                   AFn.java:   22  clojure.lang.AFn/run
;;    ThreadPoolExecutor.java: 1149  java.util.concurrent.ThreadPoolExecutor/runWorker
;;    ThreadPoolExecutor.java:  624  java.util.concurrent.ThreadPoolExecutor$Worker/run
;;                Thread.java:  748  java.lang.Thread/run

;; 1. Caused by java.lang.RuntimeException
;;    Unable to resolve symbol: STATE__ in this context



;; Wrap our login form in a stage/scene, and create a "stage" function
(defui Stage
       (render [this args]
               (ui/stage
                 :title "JavaFX Welcome"
                 :shown true
                 :scene (ui/scene
                          :root (login-window args)))))

(defn -main []
  (let [;; Data State holds the business logic of our app
        data-state (atom {:authed? false})

        ;; handler-fn handles events from the ui and updates the data state
        handler-fn (fn [{:keys [event] :as all-data}]
                     (println "UI Event" event all-data)
                     (case event
                       :auth (swap! data-state assoc :authed? true)
                       (println "Unknown UI event" event all-data)))

        ;; ui-state holds the most recent state of the ui
        ui-state (agent (dom/app (stage @data-state) handler-fn))]

    ;; Every time the data-state changes, queue up an update of the UI
    (add-watch data-state :ui (fn [_ _ _ _]
                                (send ui-state
                                      (fn [old-ui]
                                        (dom/update-app old-ui (stage @data-state))))))))
