package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.errors.CAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.cap.args.CAPErrorMessageWrapper;


/**
 * The Class TxCAPErrorMessageWrapper.
 */
public class TxCAPErrorMessageWrapper implements CAPErrorMessageWrapper {

    /** The c ap error message. */
    private CAPErrorMessage cAPErrorMessage;

    /** The message error code. */
    private CAPErrorMessageWrapper.ErrorCode messageErrorCode;

    /**
     * Instantiates a new tx cap error message wrapper.
     *
     * @param cAPErrorMessage the c ap error message
     */
    public TxCAPErrorMessageWrapper(CAPErrorMessage cAPErrorMessage) {
        this.cAPErrorMessage = cAPErrorMessage;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CAPErrorMessageWrapper#getMessageErrorCode()
     */
    @Override
    public ErrorCode getMessageErrorCode() {
        if (this.messageErrorCode == null && cAPErrorMessage != null) {
            Long errorCode = cAPErrorMessage.getErrorCode();
            for (CAPErrorMessageWrapper.ErrorCode messageErrorCode : CAPErrorMessageWrapper.ErrorCode.values()) {
                if (messageErrorCode.getValue() == errorCode.intValue())
                    this.messageErrorCode = messageErrorCode;
            }
        }
        return this.messageErrorCode;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxCAPErrorMessageWrapper [cAPErrorMessage=" + cAPErrorMessage + ", messageErrorCode=" + messageErrorCode
                + "]";
    }

}
