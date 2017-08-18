package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.map.args.ErrorComponentWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper;


/**
 * The Class TxErrorComponentWrapper.
 */
public class TxErrorComponentWrapper implements ErrorComponentWrapper{
    
    /** The map error message wrapper. */
    private MAPErrorMessageWrapper mapErrorMessageWrapper = null;
    
    /** The map error message. */
    private MAPErrorMessage mapErrorMessage;
    
    /**
     * Instantiates a new tx error component wrapper.
     *
     * @param mapErrorMessage the map error message
     */
    public TxErrorComponentWrapper(MAPErrorMessage mapErrorMessage) {
        this.mapErrorMessage = mapErrorMessage;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ErrorComponentWrapper#getMAPErrorMessage()
     */
    @Override
    public MAPErrorMessageWrapper getMAPErrorMessage() {
        if (this.mapErrorMessageWrapper == null && this.mapErrorMessage != null){
            this.mapErrorMessageWrapper = new TxMAPErrorMessageWrapper(mapErrorMessage);
        }
        return this.mapErrorMessageWrapper;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxErrorComponentWrapper [mapErrorMessage=" + mapErrorMessage + "]";
    }

}
