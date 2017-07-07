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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import pl.ovoo.jslee.ss7.wrapper.cap.args.AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SendingSideIDWrapper;

/**
 * OcApplyChargingArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxApplyChargingArgWrapper implements ApplyChargingArgWrapper {

    private transient AChBillingChargingCharacteristicsWrapper aChBillingChargingCharacteristicsWrapper = null;
    private transient SendingSideIDWrapper partyToCharge = null;

    private CAMELAChBillingChargingCharacteristics txAchBillingChargingCharacteristics;
    private SendingSideID txPartyToCharge;

    @Override
    public void setAChBillingChargingCharacteristics(
            final AChBillingChargingCharacteristicsWrapper aChBillingChargingCharacteristics) {
        if (aChBillingChargingCharacteristics == null) {
            this.txAchBillingChargingCharacteristics = null;
            this.aChBillingChargingCharacteristicsWrapper = null;
        } else {
            final TxAChBillingChargingCharacteristicsWrapper txAChBillingChargingCharacteristicsWrapper = (TxAChBillingChargingCharacteristicsWrapper) aChBillingChargingCharacteristics;
            this.txAchBillingChargingCharacteristics = txAChBillingChargingCharacteristicsWrapper
                    .getTxAchBillingChargingCharacteristics();
            this.aChBillingChargingCharacteristicsWrapper = txAChBillingChargingCharacteristicsWrapper;
        }

    }

    @Override
    public void setPartyToCharge(final SendingSideIDWrapper partyToCharge) {
        if (partyToCharge == null) {
            this.txPartyToCharge = null;
            this.partyToCharge = null;
        } else {
            final TxSendingSideIDWrapper txSendingSideIDWrapper = (TxSendingSideIDWrapper) partyToCharge;
            this.txPartyToCharge = txSendingSideIDWrapper.getTxSendingSideID();
            this.partyToCharge = txSendingSideIDWrapper;
        }

    }

    @Override
    public SendingSideIDWrapper getPartyToCharge() {
        if (this.partyToCharge == null && this.txPartyToCharge != null) {
            this.partyToCharge = new TxSendingSideIDWrapper(txPartyToCharge);
        }
        return this.partyToCharge;
    }

    public AChBillingChargingCharacteristicsWrapper getAChBillingChargingCharacteristics() {
        if (this.aChBillingChargingCharacteristicsWrapper == null && this.txAchBillingChargingCharacteristics != null) {
            this.aChBillingChargingCharacteristicsWrapper = new TxAChBillingChargingCharacteristicsWrapper(
                    txAchBillingChargingCharacteristics);
        }
        return this.aChBillingChargingCharacteristicsWrapper;
    }

    public CAMELAChBillingChargingCharacteristics getTxAchBillingChargingCharacteristics() {
        return txAchBillingChargingCharacteristics;
    }

    public void setTxAchBillingChargingCharacteristics(
            final CAMELAChBillingChargingCharacteristics txAchBillingChargingCharacteristics) {
        this.aChBillingChargingCharacteristicsWrapper = null;
        this.txAchBillingChargingCharacteristics = txAchBillingChargingCharacteristics;
    }

    public SendingSideID getTxPartyToCharge() {
        return txPartyToCharge;
    }

    public void setTxPartyToCharge(final SendingSideID txPartyToCharge) {
        this.partyToCharge = null;
        this.txPartyToCharge = txPartyToCharge;
    }

    @Override
    public String toString() {
        return "TxApplyChargingArgWrapper [txAchBillingChargingCharacteristics=" + txAchBillingChargingCharacteristics
                + ", txPartyToCharge=" + txPartyToCharge + "]";
    }

}
