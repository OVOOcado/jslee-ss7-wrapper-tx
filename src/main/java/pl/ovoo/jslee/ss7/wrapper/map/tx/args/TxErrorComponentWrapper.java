package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.map.args.ErrorComponentWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper;

public class TxErrorComponentWrapper implements ErrorComponentWrapper{
    
    private MAPErrorMessageWrapper mapErrorMessageWrapper = null;
    
    private MAPErrorMessage mapErrorMessage;
    
    public TxErrorComponentWrapper(MAPErrorMessage mapErrorMessage) {
        this.mapErrorMessage = mapErrorMessage;
    }

    @Override
    public MAPErrorMessageWrapper getMAPErrorMessage() {
        if (this.mapErrorMessageWrapper == null && this.mapErrorMessage != null){
            this.mapErrorMessageWrapper = new TxMAPErrorMessageWrapper(mapErrorMessage);
        }
        return this.mapErrorMessageWrapper;
    }

    @Override
    public String toString() {
        return "TxErrorComponentWrapper [mapErrorMessage=" + mapErrorMessage + "]";
    }

}
