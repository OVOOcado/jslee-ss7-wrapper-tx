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
 * OcApplyChargingArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxApplyChargingArgWrapper implements ApplyChargingArgWrapper {

    /** The a ch billing charging characteristics wrapper. */
    private transient AChBillingChargingCharacteristicsWrapper aChBillingChargingCharacteristicsWrapper = null;
    
    /** The party to charge. */
    private transient SendingSideIDWrapper partyToCharge = null;

    /** The tx ach billing charging characteristics. */
    private CAMELAChBillingChargingCharacteristics txAchBillingChargingCharacteristics;
    
    /** The tx party to charge. */
    private SendingSideID txPartyToCharge;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ApplyChargingArgWrapper#setAChBillingChargingCharacteristics(pl.ovoo.jslee.ss7.wrapper.cap.args.AChBillingChargingCharacteristicsWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ApplyChargingArgWrapper#setPartyToCharge(pl.ovoo.jslee.ss7.wrapper.cap.args.SendingSideIDWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ApplyChargingArgWrapper#getPartyToCharge()
     */
    @Override
    public SendingSideIDWrapper getPartyToCharge() {
        if (this.partyToCharge == null && this.txPartyToCharge != null) {
            this.partyToCharge = new TxSendingSideIDWrapper(txPartyToCharge);
        }
        return this.partyToCharge;
    }

    /**
     * Gets the a ch billing charging characteristics.
     *
     * @return the a ch billing charging characteristics
     */
    public AChBillingChargingCharacteristicsWrapper getAChBillingChargingCharacteristics() {
        if (this.aChBillingChargingCharacteristicsWrapper == null && this.txAchBillingChargingCharacteristics != null) {
            this.aChBillingChargingCharacteristicsWrapper = new TxAChBillingChargingCharacteristicsWrapper(
                    txAchBillingChargingCharacteristics);
        }
        return this.aChBillingChargingCharacteristicsWrapper;
    }

    /**
     * Gets the tx ach billing charging characteristics.
     *
     * @return the tx ach billing charging characteristics
     */
    public CAMELAChBillingChargingCharacteristics getTxAchBillingChargingCharacteristics() {
        return txAchBillingChargingCharacteristics;
    }

    /**
     * Sets the tx ach billing charging characteristics.
     *
     * @param txAchBillingChargingCharacteristics the new tx ach billing charging characteristics
     */
    public void setTxAchBillingChargingCharacteristics(
            final CAMELAChBillingChargingCharacteristics txAchBillingChargingCharacteristics) {
        this.aChBillingChargingCharacteristicsWrapper = null;
        this.txAchBillingChargingCharacteristics = txAchBillingChargingCharacteristics;
    }

    /**
     * Gets the tx party to charge.
     *
     * @return the tx party to charge
     */
    public SendingSideID getTxPartyToCharge() {
        return txPartyToCharge;
    }

    /**
     * Sets the tx party to charge.
     *
     * @param txPartyToCharge the new tx party to charge
     */
    public void setTxPartyToCharge(final SendingSideID txPartyToCharge) {
        this.partyToCharge = null;
        this.txPartyToCharge = txPartyToCharge;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxApplyChargingArgWrapper [txAchBillingChargingCharacteristics=" + txAchBillingChargingCharacteristics
                + ", txPartyToCharge=" + txPartyToCharge + "]";
    }

}
