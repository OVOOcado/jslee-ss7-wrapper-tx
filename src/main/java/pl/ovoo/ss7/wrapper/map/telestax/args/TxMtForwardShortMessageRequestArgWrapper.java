package pl.ovoo.ss7.wrapper.map.telestax.args;


import pl.ovoo.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper;
import pl.ovoo.ss7.wrapper.map.args.SmRpDaWrapper;
import pl.ovoo.ss7.wrapper.map.args.SmRpOaWrapper;
import pl.ovoo.ss7.wrapper.map.args.SmRpUiWrapper;

/**
 * Created by karolsimka on 08.06.17.
 */
public class TxMtForwardShortMessageRequestArgWrapper implements MtForwardShortMessageRequestWrapper {

    private SmRpDaWrapper smRpDaWrapper;
    private SmRpOaWrapper smRpOaWrapper;
    private SmRpUiWrapper smRpUiWrapper;

    public TxMtForwardShortMessageRequestArgWrapper() {
        super();
    }

    @Override
    public SmRpDaWrapper getSm_Rp_Da() {
        return this.smRpDaWrapper;
    }
    public void setSm_Rp_Da(SmRpDaWrapper sm_rp_da){
        this.smRpDaWrapper = sm_rp_da;
    }

    @Override
    public SmRpUiWrapper getSm_Rp_Ui() {
        return this.smRpUiWrapper;
    }
    public void setSm_Rp_Ui(SmRpUiWrapper sm_rp_ui){
        this.smRpUiWrapper = sm_rp_ui;
    }

    @Override
    public SmRpOaWrapper getSm_Rp_Oa() {
        return this.smRpOaWrapper;
    }
    public void setSm_Rp_Oa(SmRpOaWrapper sm_rp_oa){
        this.smRpOaWrapper = sm_rp_oa;
    }

    @Override
    public String toString() {
        return "TxMtForwardShortMessageRequestArgWrapper [Sm_Rp_Da=" + smRpDaWrapper + ", Sm_Rp_Oa="
                + smRpOaWrapper + ", Sm_Rp_Ui=" + smRpUiWrapper + "]";
    }

}
