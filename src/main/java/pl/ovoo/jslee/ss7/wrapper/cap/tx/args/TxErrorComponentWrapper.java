package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.errors.CAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.cap.args.CAPErrorMessageWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ErrorComponentWrapper;


/**
 * The Class TxErrorComponentWrapper.
 */
public class TxErrorComponentWrapper implements ErrorComponentWrapper {

    /** The cap error message wrapper. */
    private CAPErrorMessageWrapper capErrorMessageWrapper = null;

    /** The cap error message. */
    private CAPErrorMessage capErrorMessage;

    /**
     * Instantiates a new tx error component wrapper.
     *
     * @param capErrorMessage the cap error message
     */
    public TxErrorComponentWrapper(CAPErrorMessage capErrorMessage) {
        this.capErrorMessage = capErrorMessage;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ErrorComponentWrapper#getCAPErrorMessage()
     */
    public CAPErrorMessageWrapper getCAPErrorMessage() {
        if (this.capErrorMessageWrapper == null && this.capErrorMessage != null){
            this.capErrorMessageWrapper = new TxCAPErrorMessageWrapper(capErrorMessage);
        }
        return this.capErrorMessageWrapper;
    }

}
