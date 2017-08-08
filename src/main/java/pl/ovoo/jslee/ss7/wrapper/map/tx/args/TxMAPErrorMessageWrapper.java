package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper;

public class TxMAPErrorMessageWrapper implements MAPErrorMessageWrapper{
    
    private MAPErrorMessage mAPErrorMessage;
    
    private MAPErrorMessageWrapper.ErrorCode messageErrorCode;

    public TxMAPErrorMessageWrapper(final MAPErrorMessage mAPErrorMessage) {
        this.mAPErrorMessage = mAPErrorMessage;
    }
    
    public MAPErrorMessageWrapper.ErrorCode getMessageErrorCode(){
        if (this.messageErrorCode == null && mAPErrorMessage != null){
            Long errorCode = mAPErrorMessage.getErrorCode();
            for (MAPErrorMessageWrapper.ErrorCode messageErrorCode : MAPErrorMessageWrapper.ErrorCode.values()){
                if (messageErrorCode.getValue() == errorCode.intValue()) this.messageErrorCode =  messageErrorCode;
            }
        }
        return this.messageErrorCode;
    }

    @Override
    public String toString() {
        return "TxMAPErrorMessageWrapper [mAPErrorMessage=" + mAPErrorMessage + ", messageErrorCode=" + messageErrorCode
                + "]";
    }
    
}
