package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.errors.CAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.cap.args.CAPErrorMessageWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ErrorComponentWrapper;

public class TxErrorComponentWrapper implements ErrorComponentWrapper {

    private CAPErrorMessageWrapper capErrorMessageWrapper = null;

    private CAPErrorMessage capErrorMessage;

    public TxErrorComponentWrapper(CAPErrorMessage capErrorMessage) {
        this.capErrorMessage = capErrorMessage;
    }

    public CAPErrorMessageWrapper getCAPErrorMessage() {
        if (this.capErrorMessageWrapper == null && this.capErrorMessage != null){
            this.capErrorMessageWrapper = new TxCAPErrorMessageWrapper(capErrorMessage);
        }
        return this.capErrorMessageWrapper;
    }

}
