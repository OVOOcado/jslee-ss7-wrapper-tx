package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper;


/**
 * The Class TxMAPErrorMessageWrapper.
 */
public class TxMAPErrorMessageWrapper implements MAPErrorMessageWrapper{
    
    /** The m ap error message. */
    private MAPErrorMessage mAPErrorMessage;
    
    /** The message error code. */
    private MAPErrorMessageWrapper.ErrorCode messageErrorCode;

    /**
     * Instantiates a new tx map error message wrapper.
     *
     * @param mAPErrorMessage the m ap error message
     */
    public TxMAPErrorMessageWrapper(final MAPErrorMessage mAPErrorMessage) {
        this.mAPErrorMessage = mAPErrorMessage;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper#getMessageErrorCode()
     */
    public MAPErrorMessageWrapper.ErrorCode getMessageErrorCode(){
        if (this.messageErrorCode == null && mAPErrorMessage != null){
            Long errorCode = mAPErrorMessage.getErrorCode();
            for (MAPErrorMessageWrapper.ErrorCode messageErrorCode : MAPErrorMessageWrapper.ErrorCode.values()){
                if (messageErrorCode.getValue() == errorCode.intValue()) this.messageErrorCode =  messageErrorCode;
            }
        }
        return this.messageErrorCode;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPErrorMessageWrapper [mAPErrorMessage=" + mAPErrorMessage + ", messageErrorCode=" + messageErrorCode
                + "]";
    }
    
}
