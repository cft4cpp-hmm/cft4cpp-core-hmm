(set-option :timeout 5000)
(declare-fun tvw_x () Int)
(assert (not  (and  (>  tvw_x   0 )   (<  tvw_x   2 ) ) ) )
(assert (not  (and  (>=  tvw_x   2 )   (<=  tvw_x   5 ) ) ) )
(check-sat)(get-model)