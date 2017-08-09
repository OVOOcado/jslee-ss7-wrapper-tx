package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.errors.CAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.cap.args.CAPErrorMessageWrapper;

public class TxCAPErrorMessageWrapper implements CAPErrorMessageWrapper {

    private CAPErrorMessage cAPErrorMessage;

    private CAPErrorMessageWrapper.ErrorCode messageErrorCode;

    public TxCAPErrorMessageWrapper(CAPErrorMessage cAPErrorMessage) {
        this.cAPErrorMessage = cAPErrorMessage;
    }

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

    @Override
    public String toString() {
        return "TxCAPErrorMessageWrapper [cAPErrorMessage=" + cAPErrorMessage + ", messageErrorCode=" + messageErrorCode
                + "]";
    }

}
