/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPLocationInformationWrapper;

/**
 * TxMAPLocationInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMAPLocationInformationWrapper implements MAPLocationInformationWrapper {

    private transient ISDNAddressStringWrapper vlrNumber = null;
    private transient MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper cellGlobalIdOrServiceAreaIdOrLAI = null;

    private final LocationInformation mapLocationInformation;

    public TxMAPLocationInformationWrapper(final LocationInformation mapLocationInformation) {
        this.mapLocationInformation = mapLocationInformation;
    }

    @Override
    public ISDNAddressStringWrapper getVlrNumber() {
        if (this.vlrNumber == null && this.mapLocationInformation.getVlrNumber() != null) {
            this.vlrNumber = new TxISDNAddressStringWrapperImpl(mapLocationInformation.getVlrNumber());
        }
        return this.vlrNumber;
    }

    @Override
    public boolean hasVlrNumber() {
        return mapLocationInformation.getVlrNumber() != null;
    }

    @Override
    public boolean hasCellGlobalIdOrServiceAreaIdOrLAI() {
        return mapLocationInformation.getCellGlobalIdOrServiceAreaIdOrLAI() != null;
    }

    @Override
    public MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper getCellGlobalIdOrServiceAreaIdOrLAI() {
        if (this.cellGlobalIdOrServiceAreaIdOrLAI == null
                && this.mapLocationInformation.getCellGlobalIdOrServiceAreaIdOrLAI() != null) {
            this.cellGlobalIdOrServiceAreaIdOrLAI = new TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper(
                    mapLocationInformation.getCellGlobalIdOrServiceAreaIdOrLAI());
        }
        return this.cellGlobalIdOrServiceAreaIdOrLAI;
    }

    public LocationInformation getTxMapLocationInformation() {
        return mapLocationInformation;
    }

    @Override
    public String toString() {
        return "TxMAPLocationInformationWrapper [mapLocationInformation=" + mapLocationInformation + "]";
    }

}
