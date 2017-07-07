/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
