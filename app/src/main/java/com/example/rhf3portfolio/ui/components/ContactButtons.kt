package com.example.rhf3portfolio.ui.components // Or your appropriate package

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme // For icon tint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter // For tinting icons
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rhf3portfolio.R // Assuming your R file is here
import com.example.rhf3portfolio.ui.theme.Rhf3PortfolioTheme

// --- Assuming you have these drawables: ---
// R.drawable.ic_gmail
// R.drawable.ic_linkedin

@Composable
fun ContactButtons(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Row(
        modifier = modifier.padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactCircleButton(
            iconResId = R.drawable.gmail, // Replace with your actual Gmail icon resource ID
            contentDescription = "Contact via Gmail",
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:") // Only email apps should handle this
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("your.email@example.com")) // Replace
                    putExtra(Intent.EXTRA_SUBJECT, "Contact from Portfolio App")
                }
                try {
                    context.startActivity(emailIntent)
                } catch (e: android.content.ActivityNotFoundException) {
                    Toast.makeText(context, "No email app found.", Toast.LENGTH_SHORT).show()
                }
            }
        )

        Spacer(modifier = Modifier.width(24.dp)) // Increased spacing

        ContactCircleButton(
            iconResId = R.drawable.linkedin, // Replace with your actual LinkedIn icon resource ID
            contentDescription = "Contact via LinkedIn",
            onClick = {
                val linkedInUrl = "https://www.linkedin.com/in/yourprofile" // Replace with your LinkedIn URL
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
                try {
                    context.startActivity(intent)
                } catch (e: android.content.ActivityNotFoundException) {
                    Toast.makeText(context, "Could not open LinkedIn.", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}

@Composable
fun ContactCircleButton(
    iconResId: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconSize: Int = 24 // Size of the icon inside the button in dp
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(48.dp) // Total size of the circular button
            .clip(CircleShape) // This makes the IconButton itself circular
        // You can add .background(MaterialTheme.colorScheme.surfaceVariant) or any color
        // if you want the circle to have a fill different from its container.
        // If IconButton is placed on a colored Surface, it might not need its own background.
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            modifier = Modifier.size(iconSize.dp),
            // Optional: Tint the icon to match your theme.
            // Adjust the color based on whether the icon is on a light or dark background.
            // If your icons are already the correct color, you might not need this.
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
            // Or use onPrimary, onSecondary, etc., depending on the button's intended emphasis
            // and background. If your icons are multicolor, you might not want to tint them.
        )
    }
}

// Add these to your strings.xml:
// <string name="contact_gmail_button_description">Contact via Gmail</string>
// <string name="contact_linkedin_button_description">View LinkedIn Profile</string>

@Preview(showBackground = true)
@Composable
fun ContactButtonsPreview() {
    Rhf3PortfolioTheme {
        ContactButtons()
    }
}